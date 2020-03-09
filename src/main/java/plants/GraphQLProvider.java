package plants;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLInputObjectType;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLInputObjectField.newInputObjectField;
import static graphql.schema.GraphQLInputObjectType.newInputObject;
import static graphql.schema.GraphQLObjectType.newObject;
import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

@Component
class PlantScheduleGraphQLProvider {

    @Autowired
    PlantScheduleGraphQLDataFetchers plantScheduleGraphQLDataFetchers;

    private GraphQL graphQL;

    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("schema_plantSchedule.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("plantScheduleById", plantScheduleGraphQLDataFetchers.getPlantScheduleIdDataFetcher()))
                .type(newTypeWiring("Query")
                        .dataFetcher("plantScheduleByName", plantScheduleGraphQLDataFetchers.getPlantScheduleNameDataFetcher()))
                .type(newTypeWiring("Mutation")
                        .dataFetcher("plantSchedule", plantScheduleGraphQLDataFetchers.addPlantSchedule()))
                .type(newTypeWiring("Mutation")
                        .dataFetcher("deletePlantSchedule", plantScheduleGraphQLDataFetchers.deletePlantSchedule()))
                .build();
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }
}

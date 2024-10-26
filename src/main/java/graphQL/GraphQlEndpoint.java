package graphQL;

import com.coxautodev.graphql.tools.SchemaParser;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.LogementRepository;
import repository.RendezVousRepository;

import javax.management.Query;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graph")
public class GraphQlEndpoint extends SimpleGraphQLServlet {

    public GraphQlEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {

        LogementRepository lr = new LogementRepository();
        RendezVousRepository rdvRepo = new RendezVousRepository();

        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new QueryApi(rdvRepo , lr ) , new MutationApi(rdvRepo , lr))
                .build()
                .makeExecutableSchema();
    }
}

package graphQL;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class QueryApi implements GraphQLRootResolver {
    public RendezVousRepository RDV;
    public LogementRepository Log;
    public QueryApi(RendezVousRepository RDV, LogementRepository log) {
        this.RDV = RDV;
        this.Log = log;
    }
    public QueryApi() {}
    public List<RendezVous> getAllRdv() {
     return this.RDV.getListeRendezVous();
    }
    public List<Logement> getAllLog() {
        return this.Log.getAllLogements();
    }

    public Logement logByRef(int ref){
        return this.Log.getLogementsByReference(ref);
    }
    public List<RendezVous> getAllRdvByLog(int ref) {
        return this.RDV.getListeRendezVousByLogementRef(ref);
    }


}

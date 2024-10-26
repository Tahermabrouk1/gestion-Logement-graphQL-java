package graphQL;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

public class MutationApi implements GraphQLRootResolver {
    public RendezVousRepository RDV;
    public LogementRepository Log;
    public MutationApi(RendezVousRepository RDV, LogementRepository log) {
        this.RDV = RDV;
        this.Log = log;
    }
    public MutationApi() {}

    public RendezVous Addrdv( int id , String date , String heure , int refLog , String num){
        RendezVous rdv = new RendezVous(id, date, heure, Log.getLogementsByReference(refLog), num);
        RDV.addRendezVous(rdv);
        return rdv ;
    }

}

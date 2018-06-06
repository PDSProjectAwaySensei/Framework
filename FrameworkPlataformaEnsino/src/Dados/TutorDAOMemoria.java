package Dados;

import Dominio.Identificacao;
import Dominio.Tutor;
import java.util.ArrayList;

public class TutorDAOMemoria implements TutorDAO{
    private ArrayList<Tutor> tutores;

    public TutorDAOMemoria() {
        this.tutores = new ArrayList<>();
    }
    
    @Override
    public Boolean inserirTutor(Tutor tutor) {
        if (getTutor(tutor.getIdentificacao()) == null){
            tutores.add(tutor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void removerTutor(Tutor tutor) {
        tutores.remove(tutor);
    }

    @Override
    public void editarTutor(Tutor antigo, Tutor novo) {
        tutores.set(tutores.indexOf(antigo),novo);
    }

    @Override
    public ArrayList<Tutor> listarTutores(){
        return tutores;
    }
    
    @Override
    public Tutor getTutor(Identificacao idEntrar){            
        for (Tutor i : tutores){
            if  (i.getIdentificacao().getUsuario().equals(idEntrar.getUsuario())){
                if (i.getIdentificacao().getUsuario().equals(idEntrar.getUsuario())){
                    return i;
                }
            }
        }
        return null;
    }
}

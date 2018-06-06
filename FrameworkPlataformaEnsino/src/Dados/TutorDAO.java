package Dados;

import Dominio.Tutor;
import Dominio.Identificacao;
import java.util.ArrayList;

public interface TutorDAO {
    public abstract Boolean inserirTutor(Tutor tutor);
    public abstract void removerTutor(Tutor tutor);
    public abstract void editarTutor(Tutor tutor1, Tutor tutor2);
    public abstract ArrayList<Tutor> listarTutores();
    public abstract Tutor getTutor(Identificacao idEntrar);
}

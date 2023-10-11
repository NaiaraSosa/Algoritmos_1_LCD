package ejercicioPersonajesJuegoRol;

public class JuegoRol {
    public static void main(String[] args) {
        Wizard gandalf = new Wizard("Gandalf", 3, 30);
        Wizard zed = new Wizard("Zed", 4, 40);
        Wizard mordor = new Wizard("Mordor", 5, 50);
        Paladin sirius = new Paladin("Sirius", 4, 30);
        Wizard [] personajesAtaqueDistancia = {gandalf, zed, mordor};
        
        gandalf.mostrarEstado();    
        zed.mostrarEstado();
        mordor.mostrarEstado();
        sirius.mostrarEstado(); 
        sirius.atacar(gandalf);
        gandalf.defender(sirius);

        for (Wizard wizard : personajesAtaqueDistancia) {
            wizard.atacarADistancia (sirius);
        }
    }
}

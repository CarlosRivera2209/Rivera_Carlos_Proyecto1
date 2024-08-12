
package Login;

import java.util.ArrayList;


public class Variables {


    public ArrayList<String> getLogs() {
        return logs;
    }


    public void setLogs(ArrayList<String> aLogs) {
        logs = aLogs;
    }

    /**
     * @return the PG_VILLAINS
     */
    public ArrayList<Integer> getPG_VILLAINS() {
        return PG_VILLAINS;
    }

    /**
     * @param aPG_VILLAINS the PG_VILLAINS to set
     */
    public void setPG_VILLAINS(ArrayList<Integer> aPG_VILLAINS) {
        PG_VILLAINS = aPG_VILLAINS;
    }

    /**
     * @return the PG_HEROES
     */
    public ArrayList<Integer> getPG_HEROES() {
        return PG_HEROES;
    }

    /**
     * @param aPG_HEROES the PG_HEROES to set
     */
    public void setPG_HEROES(ArrayList<Integer> aPG_HEROES) {
        PG_HEROES = aPG_HEROES;
    }

    /**
     * @return the NombredeUsuarioH
     */
    public ArrayList<String> getNombredeUsuarioH() {
        return NombredeUsuarioH;
    }

    /**
     * @param aNombredeUsuarioH the NombredeUsuarioH to set
     */
    public void setNombredeUsuarioH(ArrayList<String> aNombredeUsuarioH) {
        NombredeUsuarioH = aNombredeUsuarioH;
    }

    /**
     * @return the Puntos
     */
    public ArrayList<Integer> getPuntos() {
        return Puntos;
    }

    /**
     * @param aPuntos the Puntos to set
     */
    public void setPuntos(ArrayList<Integer> aPuntos) {
        Puntos = aPuntos;
    }

    /**
     * @return the User2
     */
    public String getUser2() {
        return User2;
    }

    /**
     * @param aUser2 the User2 to set
     */
    public void setUser2(String aUser2) {
        User2 = aUser2;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param aUser the user to set
     */
    public void setUser(String aUser) {
        user = aUser;
    }

    public static String User2;

    /**
     * @return the Contras
     */
    public ArrayList<String> getContras() {
        return Contras;
    }

    /**
     * @param Contras the Contras to set
     */
    public void setContras(ArrayList<String> Contras) {
        this.Contras = Contras;
    }
    public static ArrayList<String> Contras = new ArrayList<>();
    public static ArrayList<String> NombredeUsuario = new ArrayList<>();
    public static ArrayList<Integer> Puntos = new ArrayList<>();
    public static ArrayList<String> NombredeUsuarioH = new ArrayList<>();
    public static ArrayList<Integer> PG_HEROES = new ArrayList<>();
    public static ArrayList<Integer> PG_VILLAINS = new ArrayList<>();
    public static ArrayList<String> logs = new ArrayList<>();

    /**
     * @return the NombredeUsuario
     */
    public ArrayList<String> getNombredeUsuario() {
        return NombredeUsuario;
    }

    /**
     * @param NombredeUsuario the NombredeUsuario to set
     */
    public void setNombredeUsuario(ArrayList<String> NombredeUsuario) {
        this.NombredeUsuario = NombredeUsuario;
    }

    public static String user;

}

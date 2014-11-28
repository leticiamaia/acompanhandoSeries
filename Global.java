import play.*;

public class Global extends GlobalSettings {

    public void onStart(Application app) {
        Logger.info("Aplicação inicializada...");
    }

    public void onStop(Application app) {
        Logger.info("Aplicação desligada...");
    }
}

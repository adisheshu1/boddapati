package y.webapp.pages.admin;

import org.apache.wicket.RestartResponseException;
import org.apache.wicket.model.ResourceModel;
import y.webapp.listener.StartupListener;
import y.webapp.pages.AbstractWebPage;
import org.wicketstuff.annotation.mount.MountPath;

/**
 * Page for reloading an application configuration.
 *
 * @author Marcin Zajączkowski, 2011-02-12
 */
@MountPath("admin/reload")
public class Reload extends AbstractWebPage {

    @Override
    protected void onInitialize() {
        super.onInitialize();

        StartupListener.setupContext(getServletContext());

        getSession().info(createDefaultInfoNotificationMessage(new ResourceModel("reload.succeeded")));
        throw new RestartResponseException(getApplication().getHomePage());
    }
}

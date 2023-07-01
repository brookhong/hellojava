package module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import component.H1Template;

public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
    }

    @Provides
    public H1Template getH1Template() {
        return new H1Template("zh_CN", "B004IJO7K8", new H1Template.Tags("/{desc}/{pageId}/"));
    }
}

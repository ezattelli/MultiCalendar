package ir.etelli.gateway;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;

import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.common.project.resource.adapter.ResourceTypeAdapterRegistry;
import com.inductiveautomation.ignition.gateway.dataroutes.RouteGroup;
import com.inductiveautomation.ignition.gateway.model.AbstractGatewayModuleHook;
import com.inductiveautomation.ignition.gateway.model.GatewayContext;
import com.inductiveautomation.ignition.gateway.web.models.ConfigCategory;
import com.inductiveautomation.ignition.gateway.web.models.IConfigTab;
import com.inductiveautomation.ignition.gateway.web.models.SystemMap;
import com.inductiveautomation.ignition.gateway.web.pages.config.overviewmeta.ConfigOverviewContributor;
import com.inductiveautomation.ignition.gateway.web.pages.status.overviewmeta.OverviewContributor;
import com.inductiveautomation.perspective.common.api.ComponentRegistry;
import com.inductiveautomation.perspective.gateway.api.PerspectiveContext;
import ir.etelli.common.PersiancalendarModule;
import ir.etelli.common.component.PersianCalendar;
import ir.etelli.common.component.PersianDatePiker;
import ir.etelli.common.component.PersianDatePikerRange;

/**
 * Class which is instantiated by the Ignition platform when the module is loaded in the gateway scope.
 */
public class PersiancalendarGatewayHook extends AbstractGatewayModuleHook {

    private ComponentRegistry componentRegistry;

    private GatewayContext gatewayContext;
    @Override
    public void setup(GatewayContext context) {
        this.gatewayContext = context;

    }


    @Override
    public void startup(LicenseState activationState) {
        PerspectiveContext perspectiveContext = PerspectiveContext.get(this.gatewayContext);
        this.componentRegistry = perspectiveContext.getComponentRegistry();

        if (this.componentRegistry != null) {
            this.componentRegistry.registerComponent(PersianCalendar.DESCRIPTOR);
            this.componentRegistry.registerComponent(PersianDatePiker.DESCRIPTOR);
            this.componentRegistry.registerComponent(PersianDatePikerRange.DESCRIPTOR);
        }

    }


    @Override
    public void shutdown() {
        if (this.componentRegistry != null) {
            this.componentRegistry.removeComponent(PersianDatePiker.COMPONENT_ID);
            this.componentRegistry.removeComponent(PersianDatePikerRange.COMPONENT_ID);
        }
    }


    @Override
    public List<? extends IConfigTab> getConfigPanels() {
        return null;
    }


    @Override
    public List<ConfigCategory> getConfigCategories() {
        return null;
    }


    @Override
    public Optional<String> getMountedResourceFolder() {
        return Optional.of("mounted");
    }


    @Override
    public void mountRouteHandlers(RouteGroup routes) {

    }


    @Override
    public Optional<String> getMountPathAlias() {
        return Optional.of(PersiancalendarModule.URL_ALIAS);
    }


    @Override
    public boolean isFreeModule() {
        return true;
    }


//    @Override
//    public Optional<OverviewContributor> getStatusOverviewContributor() {
//        return Optional.empty();
//    }


//    @Override
//    public Optional<ConfigOverviewContributor> getConfigOverviewContributor() {
//        return Optional.empty();
//    }


//    @Override
//    public void initializeResourceTypeAdapterRegistry(ResourceTypeAdapterRegistry registry) {
//
//    }

//    @Override
//    public void onMountedResourceRequest(String resourcePath, HttpServletResponse response) {
//
//    }
}

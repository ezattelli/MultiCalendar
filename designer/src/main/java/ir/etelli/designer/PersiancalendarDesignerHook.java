package ir.etelli.designer;

import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.designer.model.AbstractDesignerModuleHook;
import com.inductiveautomation.ignition.designer.model.DesignerContext;
import com.inductiveautomation.perspective.designer.DesignerComponentRegistry;
import com.inductiveautomation.perspective.designer.api.PerspectiveDesignerInterface;
import ir.etelli.common.component.PersianCalendar;
import ir.etelli.common.component.PersianDatePiker;
import ir.etelli.common.component.PersianDatePikerRange;


/**
 * This is the Designer-scope module hook.  The minimal implementation contains a startup method.
 */
public class PersiancalendarDesignerHook extends AbstractDesignerModuleHook {

    // override additonal methods as requried
    private DesignerComponentRegistry registry;

    @Override
    public void startup(DesignerContext context, LicenseState activationState) throws Exception {
        // implelement functionality as required
        PerspectiveDesignerInterface pdi = PerspectiveDesignerInterface.get(context);
        registry = pdi.getDesignerComponentRegistry();
        registry.registerComponent(PersianCalendar.DESCRIPTOR);
        registry.registerComponent(PersianDatePiker.DESCRIPTOR);
        registry.registerComponent(PersianDatePikerRange.DESCRIPTOR);
    }

    @Override
    public void shutdown() {
        registry.removeComponent(PersianCalendar.COMPONENT_ID);
        registry.removeComponent(PersianDatePiker.COMPONENT_ID);
        registry.removeComponent(PersianDatePikerRange.COMPONENT_ID);
    }

}

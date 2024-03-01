package ir.etelli.common.component;

import com.inductiveautomation.ignition.common.jsonschema.JsonSchema;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;
import ir.etelli.common.PersiancalendarModule;
//import ir.etelli.common.MyTimeLine;
//import org.fakester.common.RadComponents;


public class PersianDatePiker {

    // unique ID of the component which perfectly matches that provided in the javascript's ComponentMeta implementation
    public static String COMPONENT_ID = "ir.etelli.persiandatepicker";


    public static JsonSchema SCHEMA =
        JsonSchema.parse(PersianDatePiker.class.getResourceAsStream("/persiancalendar.props.json"));



    public static ComponentDescriptor DESCRIPTOR = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
        .setPaletteCategory(PersiancalendarModule.COMPONENT_CATEGORY)
        .setId(COMPONENT_ID)
        .setModuleId(PersiancalendarModule.MODULE_ID)
        .setSchema(SCHEMA) //  this could alternatively be created purely in Java if desired
//            .setEvents(Arrays.asList(ON_SELECT_MODE))
        .setName("DatePicker")
        .addPaletteEntry("", "DatePicker", "Multi DatePicker: gregorian,persian,jalali,arabic,indian.", null, null)
        .setDefaultMetaName("DatePicker")
        .setResources(PersiancalendarModule.BROWSER_RESOURCES)
        .build();

}

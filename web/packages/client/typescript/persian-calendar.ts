import {ComponentMeta, ComponentRegistry} from '@inductiveautomation/perspective-client';

import '../scss/main';
import {PersianCalendar, PersianCalendarMeta} from "./components/PersianCalendar";
import {PersianDatePicker ,PersianDatePickerMeta} from "./components/PersianDatePicker";
import {PersianDatePickerRange , PersianDatePickerRangeMeta} from "./components/PersianDatePickerRange";

export {PersianCalendar,PersianDatePicker,PersianDatePickerRange};

const components: Array<ComponentMeta> = [
    new PersianCalendarMeta(), new PersianDatePickerMeta(),new PersianDatePickerRangeMeta()
];

components.forEach((c: ComponentMeta) => ComponentRegistry.register(c) );

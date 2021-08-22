import { DatePipe } from '@angular/common';
import { NgModule } from '@angular/core';
import { DataDirective } from './data.directive';
@NgModule({
    declarations:[DataDirective],
    providers:[DatePipe],
    exports:[DataDirective],
})
export class DataDirectiveModule{}
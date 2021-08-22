import { DataDirectiveModule } from './../../utils/data-directive.module';
import { NgModule } from "@angular/core";
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { MedicoCadastroComponent } from './cadastro/medico-cadastro.component';
import { MedicoComponent } from './medico.component';
import { MedicoRouting } from './medico.routing';
import { MedicoPesquisaComponent } from './pesquisa/medico-pesquisa.component';


@NgModule({
    declarations:[
        MedicoComponent,
        MedicoCadastroComponent,
        MedicoPesquisaComponent
    ],
    imports:[CommonModule,ReactiveFormsModule,DataDirectiveModule],
    exports:[MedicoRouting]
})
export class MedicoModule{}
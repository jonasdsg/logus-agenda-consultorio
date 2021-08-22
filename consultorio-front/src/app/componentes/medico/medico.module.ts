import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NgModule } from "@angular/core";

import { MedicoRouting } from './medico.routing';
import { MedicoComponent } from './medico.component';
import { MedicoPesquisaComponent } from './pesquisa/medico-pesquisa.component';
import { MedicoCadastroComponent } from './cadastro/medico-cadastro.component';

@NgModule({
    declarations:[
        MedicoComponent,
        MedicoCadastroComponent,
        MedicoPesquisaComponent
    ],
    imports:[CommonModule,ReactiveFormsModule],
    exports:[MedicoRouting]
})
export class MedicoModule{}
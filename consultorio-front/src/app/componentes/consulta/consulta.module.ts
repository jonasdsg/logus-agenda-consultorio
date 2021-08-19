import { ConsultaComponent } from './consulta.component';
import { ConsultaListagemComponent } from './pesquisa/consulta-listagem.component';
import { CommonModule } from '@angular/common';
import { NgModule } from "@angular/core";
import { ReactiveFormsModule } from "@angular/forms";

import { ConsultaCadastroComponent } from './cadastro/consulta-cadastro.component';
import { ConsultaRouting } from './consulta.routing';
import { ConsultaPesquisaComponent } from './pesquisa/consulta-pesquisa.component';


@NgModule({
    declarations:[
        ConsultaCadastroComponent,
        ConsultaPesquisaComponent,
        ConsultaListagemComponent,
        ConsultaComponent
    ],
    imports:[
        CommonModule,
        ReactiveFormsModule
    ],
    exports:[
        ConsultaRouting
    ]
})
export class ConsultaModule{}
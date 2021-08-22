import { ConsultaComponent } from './consulta.component';
import { ConsultaListagemComponent } from './pesquisa/consulta-listagem.component';
import { CommonModule } from '@angular/common';
import { NgModule } from "@angular/core";
import { ReactiveFormsModule } from "@angular/forms";

import { ConsultaRouting } from './consulta.routing';
import { ConsultaCadastroComponent } from './cadastro/consulta-cadastro.component';
import { DataDirectiveModule } from './../../utils/data-directive.module';
import { ConsultaPesquisaComponent } from './pesquisa/consulta-pesquisa.component';


@NgModule({
    declarations:[
        ConsultaCadastroComponent,
        ConsultaPesquisaComponent,
        ConsultaListagemComponent,
        ConsultaComponent,
    ],
    imports:[
        CommonModule,
        ReactiveFormsModule,
        DataDirectiveModule
    ],
    exports:[
        ConsultaRouting
    ]
})
export class ConsultaModule{}
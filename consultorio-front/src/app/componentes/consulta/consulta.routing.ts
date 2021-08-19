import { ConsultaPesquisaComponent } from './pesquisa/consulta-pesquisa.component';
import { ConsultaCadastroComponent } from './cadastro/consulta-cadastro.component';
import { NgModule } from "@angular/core";
import { Router, RouterModule } from "@angular/router";

@NgModule({
    imports:[
        RouterModule.forRoot([
            {
                path:'consulta-cadastro',
                component: ConsultaCadastroComponent
            },
            {
                path:'consulta-pesquisa',
                component: ConsultaPesquisaComponent,
            }
        ])
    ]
})
export class ConsultaRouting {}
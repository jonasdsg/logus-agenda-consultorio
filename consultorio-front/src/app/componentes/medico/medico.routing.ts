import { MedicoPesquisaComponent } from './pesquisa/medico-pesquisa.component';
import { MedicoCadastroComponent } from './cadastro/medico-cadastro.component';
import { RouterModule } from '@angular/router';
import { NgModule } from "@angular/core";

@NgModule({
    imports:[
        RouterModule.forRoot([
            {
                path: 'medico-cadastro',
                component: MedicoCadastroComponent,
            },
            {
                path: 'medico-pesquisa',
                component: MedicoPesquisaComponent
            }
        ])
    ]
})
export class MedicoRouting{}
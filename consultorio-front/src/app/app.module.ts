import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';

import { ConsultaModule } from './componentes/consulta/consulta.module';
import { MedicoModule } from './componentes/medico/medico.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    RouterModule,
    BrowserModule,
    HttpClientModule,

    ConsultaModule,
    MedicoModule,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

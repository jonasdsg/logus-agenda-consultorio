import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { ConsultaModule } from './componentes/consulta/consulta.module';
import { MedicoModule } from './componentes/medico/medico.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    RouterModule,
    BrowserModule,
    HttpClientModule,
    
    ConsultaModule,
    MedicoModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

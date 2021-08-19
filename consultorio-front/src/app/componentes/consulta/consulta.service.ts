import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Consulta } from './../../models/consulta.model';
import { BackendService } from './../BackendService.model';

@Injectable({
    providedIn: 'root'
})
export class ConsultaService extends BackendService {

    constructor(private http: HttpClient) {
        super('consulta');
    }

    save(consulta: Consulta){
        return this.http.post(this.baseUrl,consulta,this.getOptions);
    }

    findAll(){
        return this.http.get(this.baseUrl,this.getOptions);
    }

    findByFilters(params){
        let options = {
            headers: this.getOptions.headers,
            params:params
        }
        return this.http.get(this.baseUrl,options)
    }
}
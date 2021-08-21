import { HttpClient, HttpHeaders } from "@angular/common/http";
const BACKEND_BASE_URL = 'http://localhost:8080';

export class BackendService <T> {

    constructor(
        private path:string,
        private http:HttpClient){
        this.setPath = path;
    }

    private httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
    }
    
    set setPath(path: string) {
        this.path = path;
    }

    get getOptions() {
        return this.httpOptions;
    }

    get baseUrl() {
        return `${BACKEND_BASE_URL}/${this.path}`;
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

    save(consulta: T){
        return this.http.post(this.baseUrl,consulta,this.getOptions);
    }
}
import { HttpHeaders } from "@angular/common/http";
const BACKEND_BASE_URL = 'http://localhost:8080';

export class BackendService {

    constructor(private path:string){
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
}
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JobgraphService {

  private baseUrl = 'http://localhost:8081/api';

  constructor(private http: HttpClient) {}

  getCandidates(): Observable<any[]> {
    return this.http.get<any[]>(
      `${this.baseUrl}/candidates`
    );
  }

  getCandidate(id: number): Observable<any> {
    return this.http.get<any>(
      `${this.baseUrl}/candidates/${id}`
    );
  }

  getCandidateSkills(id: number): Observable<any[]> {
    return this.http.get<any[]>(
      `${this.baseUrl}/candidates/${id}/skills`
    );
  }

  getJobs(): Observable<any[]> {
    return this.http.get<any[]>(
      `${this.baseUrl}/jobs`
    );
  }

  getJobSkills(id: number): Observable<any[]> {
    return this.http.get<any[]>(
      `${this.baseUrl}/jobs/${id}/skills`
    );
  }

  getRecommendations(id: number): Observable<any[]> {
    return this.http.get<any[]>(
      `${this.baseUrl}/candidates/${id}/recommendations`
    );
  }

  getSkillGap(id: number): Observable<any[]> {
    return this.http.get<any[]>(
      `${this.baseUrl}/candidates/${id}/skill-gap`
    );
  }

  getCourses(id: number): Observable<any[]> {
    return this.http.get<any[]>(
      `${this.baseUrl}/candidates/${id}/courses`
    );
  }
}

import { Component, OnInit } from '@angular/core';

import { CommonModule } from '@angular/common';
import { JobgraphService } from '../../services/jobgraph.service';
@Component({
  selector: 'app-dashboard',
  standalone: false,
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit {

  candidates: any[] = [];
  jobs: any[] = [];
  skills: any[] = [];

  constructor(
    private jobgraphService: JobgraphService
  ) {}

  ngOnInit(): void {

    this.jobgraphService
      .getCandidates()
      .subscribe(data => {
        this.candidates = data;
      });

    this.jobgraphService
      .getJobs()
      .subscribe(data => {
        this.jobs = data;
      });
  }

}

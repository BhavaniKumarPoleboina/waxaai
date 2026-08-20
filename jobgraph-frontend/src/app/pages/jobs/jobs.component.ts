import { Component, OnInit } from '@angular/core';
import { JobgraphService } from '../../services/jobgraph.service';

@Component({
  selector: 'app-jobs',
  standalone: false,
  templateUrl: './jobs.component.html',
  styleUrl: './jobs.component.css'
})
export class JobsComponent implements OnInit {

  jobs: any[] = [];

  constructor(
    private jobgraphService: JobgraphService
  ) {}

  ngOnInit(): void {

    this.jobgraphService
      .getJobs()
      .subscribe(data => {
        this.jobs = data;
      });
  }

}

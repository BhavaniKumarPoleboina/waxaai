import { Component, OnInit } from '@angular/core';
import { JobgraphService } from '../../services/jobgraph.service';

@Component({
  selector: 'app-candidates',
  standalone: false,
  templateUrl: './candidates.component.html',
  styleUrl: './candidates.component.css'
})
export class CandidatesComponent implements OnInit {

  candidates: any[] = [];

  constructor(
    private jobgraphService: JobgraphService
  ) {}

  ngOnInit(): void {

    this.jobgraphService
      .getCandidates()
      .subscribe(data => {
        this.candidates = data;
      });
  }
}

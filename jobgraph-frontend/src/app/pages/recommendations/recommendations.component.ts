import { Component, OnInit } from '@angular/core';
import { JobgraphService } from '../../services/jobgraph.service';

@Component({
  selector: 'app-recommendations',
  standalone: false,
  templateUrl: './recommendations.component.html',
  styleUrl: './recommendations.component.css'
})
export class RecommendationsComponent implements OnInit {

  recommendations: any[] = [];

  candidateId = 1;

  constructor(
    private jobgraphService: JobgraphService
  ) {}

  ngOnInit(): void {

    this.loadRecommendations();

  }

  loadRecommendations(): void {

    this.jobgraphService
      .getRecommendations(this.candidateId)
      .subscribe(data => {

        this.recommendations = data;

      });
  }

}

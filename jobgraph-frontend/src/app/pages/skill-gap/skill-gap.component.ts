import { Component, OnInit } from '@angular/core';
import { JobgraphService } from '../../services/jobgraph.service';

@Component({
  selector: 'app-skill-gap',
  standalone: false,
  templateUrl: './skill-gap.component.html',
  styleUrl: './skill-gap.component.css'
})
export class SkillGapComponent implements OnInit {

  skillGaps: any[] = [];

  candidateId = 1;

  constructor(
    private jobgraphService: JobgraphService
  ) {}

  ngOnInit(): void {

    this.jobgraphService
      .getSkillGap(this.candidateId)
      .subscribe(data => {

        this.skillGaps = data;

      });
  }

}

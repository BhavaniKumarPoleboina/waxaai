import { Component, OnInit } from '@angular/core';
import { JobgraphService } from '../../services/jobgraph.service';

@Component({
  selector: 'app-courses',
  standalone: false,
  templateUrl: './courses.component.html',
  styleUrl: './courses.component.css'
})
export class CoursesComponent implements OnInit {

  courses: any[] = [];

  candidateId = 1;

  constructor(
    private jobgraphService: JobgraphService
  ) {}

  ngOnInit(): void {

    this.jobgraphService
      .getCourses(this.candidateId)
      .subscribe(data => {

        this.courses = data;

      });
  }

}

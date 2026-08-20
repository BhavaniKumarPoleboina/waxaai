import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CoursesComponent } from './pages/courses/courses.component';
import { SkillGapComponent } from './pages/skill-gap/skill-gap.component';
import { RecommendationsComponent } from './pages/recommendations/recommendations.component';
import { JobsComponent } from './pages/jobs/jobs.component';
import { CandidatesComponent } from './pages/candidates/candidates.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';

const routes: Routes = [

     {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full'
  },

  {
    path: 'dashboard',
    component: DashboardComponent
  },

  {
    path: 'candidates',
    component: CandidatesComponent
  },

  {
    path: 'jobs',
    component: JobsComponent
  },

  {
    path: 'recommendations',
    component: RecommendationsComponent
  },

  {
    path: 'skill-gap',
    component: SkillGapComponent
  },

  {
    path: 'courses',
    component: CoursesComponent
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

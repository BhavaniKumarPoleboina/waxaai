import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { CandidatesComponent } from './pages/candidates/candidates.component';
import { JobsComponent } from './pages/jobs/jobs.component';
import { RecommendationsComponent } from './pages/recommendations/recommendations.component';
import { SkillGapComponent } from './pages/skill-gap/skill-gap.component';
import { CoursesComponent } from './pages/courses/courses.component';
import { provideHttpClient } from '@angular/common/http';
import { provideRouter } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    CandidatesComponent,
    JobsComponent,
    RecommendationsComponent,
    SkillGapComponent,
    CoursesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    provideClientHydration(withEventReplay()),
    
  provideHttpClient()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

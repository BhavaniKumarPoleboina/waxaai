import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SkillGapComponent } from './skill-gap.component';

describe('SkillGapComponent', () => {
  let component: SkillGapComponent;
  let fixture: ComponentFixture<SkillGapComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SkillGapComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SkillGapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { JobgraphService } from './jobgraph.service';

describe('JobgraphService', () => {
  let service: JobgraphService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JobgraphService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

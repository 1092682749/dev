import { ContentToSafeHtmlPipe } from './content-to-safe-html.pipe';

describe('ContentToSafeHtmlPipe', () => {
  it('create an instance', () => {
    const pipe = new ContentToSafeHtmlPipe();
    expect(pipe).toBeTruthy();
  });
});

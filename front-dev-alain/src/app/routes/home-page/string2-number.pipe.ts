import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'string2Number'
})
export class String2NumberPipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): unknown {
    return parseInt(value);
  }

}

function distribute(m, n) {  
  if (n <= 0) {return []};
  if (m <= 0) { 
    let m = 0; 
    let noLuck = m.toString().repeat(n).split('');
    let sadArr = [];
    noLuck.forEach(function(i) { sadArr.push(Number(i))})
    return sadArr;
  };
  let extraCandies = m % n;
  let leastPossibleCandyAmount = Math.floor( m / n );
  let numArr = [];
  for(var i = 0; i < n; i++) numArr.push(leastPossibleCandyAmount);
  for (let i = 0; i < extraCandies; i++) {
  numArr[i] = numArr[i] + 1 ;;
  }
return numArr;
}

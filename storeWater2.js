function storeWater2(height) {
    let lp = 0, rp = height.length - 1;
    let maxWater = 0;

    while (lp < rp) {
        const curr = Math.min(height[lp], height[rp]) * (rp - lp);
        maxWater = Math.max(maxWater, curr);

        if (height[lp] < height[rp]) lp++;
        else rp--;
    }

    return maxWater;
}


const heights = [1,8,6,2,5,4,8,3,7];
console.log(storeWater2(heights)); 
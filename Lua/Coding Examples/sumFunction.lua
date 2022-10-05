function getSum(array)
    sum = 0
    for i,v in ipairs(array) do
        sum = sum + v
    end
    return sum
end

odds = {1, 3, 5, 7, 9}
print(getSum(odds))
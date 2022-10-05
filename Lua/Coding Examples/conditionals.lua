--if (true)
flag = 0;
if (flag) then print("flag is not false") end

--if (false)
flag = false
if flag then print("flag is not false") else print("flag is false") end


--nested ifs
a, b = 1, 2
if a < 0 then
    print("a is less than 0")
    if b < a then
        print("b is less than a; b is also less than 0")
    end
else
    print("a is greater than 0")
    if b > a then
        print("b is greater a; b is also greater than 0")
    end
end

--elseifs
b = 2
if b < 0 then
    print("b is less than 0")
elseif b > 1 then
    print("b is greater than 1")
else
    print("b is between 0 and 1")
end



for i=2,20,2 do
    print(i)
    if(i == 10) then
        goto skip
    end
end
print("*loop end*")

::skip::

print("*program end*")
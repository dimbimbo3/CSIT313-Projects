function multiReturn()
    str1="This "
    str2="is "
    str3="all "
    str4="one "
    str5="return."

    return str1, str2, str3, str4, str5
end

a,b,c,d = multiReturn()

print(a..b..c..d)
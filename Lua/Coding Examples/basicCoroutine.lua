thread_1 = coroutine.create(
    function()
        print("Coroutine is executing. (x1)")
        coroutine.yield() --coroutine yields so another thread is able to execute
        print("Coroutine is executing. (x2)")
        coroutine.yield() --coroutine yields so another thread is able to execute
        print("Coroutine is executing. (x3)")
    end
)

--Thread Information
print("data type: "..type(thread_1))
print(thread_1) --prints the thread's address
print("thread status: "..coroutine.status(thread_1).."\n")

coroutine.resume(thread_1) --starts the thread's coroutine
coroutine.resume(thread_1) --restarts the thread's coroutine
coroutine.resume(thread_1) --restarts the thread's coroutine
print("thread status: "..coroutine.status(thread_1)) --thread status now its coroutine has completed
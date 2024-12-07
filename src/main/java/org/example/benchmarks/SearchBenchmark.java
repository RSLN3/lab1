package org.example.benchmarks;

import com.search.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;


import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class SearchBenchmark {

    private static final int[] array = {10, 20, 30, 40, 50};
    private static final int target = 30;

    @Benchmark
    public int benchmarkLinearSearch() {
        return LinearSearch.search(array, target);
    }

    @Benchmark
    public int benchmarkBinarySearch() {
        return BinarySearch.search(array, target);
    }

    @Benchmark
    public int benchmarkJumpSearch() {
        return JumpSearch.search(array, target);
    }

    @Benchmark
    public int benchmarkExponentialSearch() {
        return ExponentialSearch.search(array, target);
    }

    @Benchmark
    public int benchmarkInterpolationSearch() {
        return InterpolationSearch.search(array, target);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SearchBenchmark.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}

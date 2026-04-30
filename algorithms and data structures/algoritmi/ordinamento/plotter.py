import matplotlib.pyplot as plt

with open("report.txt", "r") as file:
    lines = file.readlines()

x_data = list(map(lambda x: int(x), lines[0].split()))
y_data = [list(map(float, line.split())) for line in lines[1:]]

algos = ["INSERTION", "MERGE", "HYBRIDMERGE", "QUICK", "MOTQUICK"] # "TAILQUICK", "HEAPSORT", "INTROSORT"]

for i, time in enumerate(y_data):
    plt.plot(x_data, time, label=algos[i])

plt.xlabel("Size")
plt.ylabel("Elapsed time [s]")
plt.title("Sorting experiments")
plt.legend()

plt.savefig("sorting_experiments.png", dpi=300, bbox_inches="tight")
# plt.show()

import re


def main():
    word_list = map("greeneggsandham.txt")
    term_frequency_list = partition(word_list)
    word_count = reduce(term_frequency_list)
    write_result("out.txt", word_count)


def map(file_name):
    with open(file_name, 'r') as fileIn:
        results = []
        for line in fileIn.readlines():
            words = re.findall('[a-z-]+', line.lower())
            for word in words:
                results.append((word, 1))
        return results


def partition(word_list):
    term_frequency_list = dict()
    for word, count in word_list:
        if word in term_frequency_list:
            term_frequency_list[word].append(count)
        else:
            term_frequency_list[word] = [count]
    return term_frequency_list


def reduce(term_frequency_list):
    results = []
    for key in sorted(term_frequency_list.keys()):
        results.append((key, sum(term_frequency_list[key])))
    return results


def write_result(file_name, result):
    with open(file_name, 'w') as fileOut:
        for word, count in result:
            fileOut.write("%s %d\n" % (word, count))


if __name__ == '__main__':
    main()

input_filename = 'data.txt';
input_table = readtable(input_filename);

output_table = input_table;
[rows, cols] = size(input_table);
for i = 2: rows
    output_table.y(i) = input_table.y(i) + randi(60) - 30;
end

plot(input_table.x, input_table.y, ...
    output_table.x,output_table.y)
legend({'Original','Salted'});

output_filename = 'salteddata.txt';
writetable(output_table, output_filename);
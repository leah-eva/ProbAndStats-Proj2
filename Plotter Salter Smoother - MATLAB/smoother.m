input_filename = 'salteddata.txt';
input_table = readtable(input_filename);

x = input_table{:, [1]};
y_intial = input_table{:,[2]};
y = movmean(y_intial, 2);

output_table = table(x,y);

plot(input_table.x, input_table.y, ...
    output_table.x,output_table.y)
legend({'Original','Smoothed'});

output_filename = 'smootheddata.txt';
writetable(output_table, output_filename);